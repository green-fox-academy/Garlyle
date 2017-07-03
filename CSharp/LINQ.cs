using System;
using System.Collections.Generic;
using System.Linq;

namespace ConsoleApplication
{
    public class Program
    {
        public static void Main(string[] args)
        {
            int[] n = { 1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14 };

            IEnumerable<int> evenNumbers = n.Where(i => i % 2 == 0);
            foreach (int i in evenNumbers)
            {
                Console.Write(i + " ");
            }
            Console.WriteLine();

            double average = n.Where(i => i % 2 != 0).Average();
            Console.WriteLine(average);

            IEnumerable<int> squaredPositives = n.Where(i => i > 0).Select(i => i * i);
            foreach (int i in squaredPositives)
            {
                Console.Write(i + " ");
            }
            Console.WriteLine();
        }
    }
}
