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
                table.printMap();
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
    }
}