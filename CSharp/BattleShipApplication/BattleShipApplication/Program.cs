using System;
using System.Drawing;
using System.Drawing.Imaging;
using System.Text.RegularExpressions;
using System.Windows.Forms;

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

            while (hits < 37)
            {
                Console.Clear();
                table.printMap();
                drawDisplay();
                Console.Write("Target: ");
                string input = Console.ReadLine();
                try
                {
                    int x = input[0] - 'A';
                    int y = Int32.Parse(Regex.Match(input, "\\d+").Value) - 1;
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
                catch (Exception ex)
                {
                    Console.WriteLine("Not valid");
                }
            }
            makeScreenshot();
        }

        private static void makeScreenshot()
        {
            Rectangle bounds = Screen.GetBounds(Point.Empty);
            using(Bitmap bitmap = new Bitmap(bounds.Width, bounds.Height))
            {
                using(Graphics g = Graphics.FromImage(bitmap))
                {
                     g.CopyFromScreen(Point.Empty, Point.Empty, bounds.Size);
                }
                bitmap.Save("screenshot.jpg", ImageFormat.Jpeg);
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