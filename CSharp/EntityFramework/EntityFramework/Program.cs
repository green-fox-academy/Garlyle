using System;
using System.Collections.Generic;
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

        public Dictionary<char, int> Count(string line)
        {
            Dictionary<char, int> countedLetters = new Dictionary<char, int>();

            foreach (Char letter in line.ToCharArray())
            {
                char value = Char.ToLower(letter);
                if (countedLetters.ContainsKey(value))
                {
                    countedLetters[value] = countedLetters[value] + 1;
                }
                else
                {
                    countedLetters.Add(value, 1);
                }
            }
            
            return countedLetters;
        }
    }
}
