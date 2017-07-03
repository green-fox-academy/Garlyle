using System;
using System.Collections.Generic;

namespace BattleShipApplication
{
    internal class Program
    {
        private static int hits = 0;
        private static int misses = 0;
        private static int total = 0;

        public static void Main(string[] args)
        {
            GameTable table = new GameTable();
            table.init();

            while (true)
            {
                Console.Clear();
                table.printMap();
                drawDisplay();
                Console.Write("Target: ");
                string input = Console.ReadLine();
                int x = input[0] - 'A';
                int y = input[1] - 'A';
                if (table.hit(x, y))
                {
                    hits++;
                }
                else
                {
                    misses++;
                }
                total++;
            }
        }

        private static void drawDisplay()
        {
            Console.SetCursorPosition(50, 2);
            Console.Write("Hit: " + hits);
            Console.SetCursorPosition(50, 3);
            Console.Write("Miss: " + misses);
            Console.SetCursorPosition(50, 4);
            Console.Write("Total: " + total);
            Console.SetCursorPosition(0, 22);
        }
    }
}