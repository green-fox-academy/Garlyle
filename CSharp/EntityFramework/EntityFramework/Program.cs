using System;
using System.Linq;
using System.Text.RegularExpressions;

namespace EntityFramework
{
    public class Program
    {
        public static void Main(string[] args)
        {
        }

        public bool areAnagrams(string first, string second)
        {
            return Enumerable.SequenceEqual(getCharacters(first), getCharacters(second));
        }

        private char[] getCharacters(string line)
        {
            line = line.ToLower();
            line = Regex.Replace(line, "\\s+", "");
            char[] result = line.ToCharArray();
            Array.Sort(result);

            return result;
        }
    }
}
