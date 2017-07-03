using System;
using System.Collections.Generic;

namespace BattleShipApplication
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            GameTable table = new GameTable();
            table.init();
            table.printMap();
        }
    }
}