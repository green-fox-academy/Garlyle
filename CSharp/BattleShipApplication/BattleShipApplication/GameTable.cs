using System;

namespace BattleShipApplication
{
    public class GameTable
    {
        private const char NONE_TILE = '.';
        private const char HIT_TILE = 'X';
        private const char MISS_TILE = 'O';

        private bool[,] visibilityMap = new bool[20,20];
        private bool[,] shipMap = new bool[20, 20];

        public bool hasShip(int x, int y)
        {
            return shipMap[x, y];
        }

        public char getTile(int x, int y)
        {
            if (!visibilityMap[x, y])
            {
                return NONE_TILE;
            } else if (shipMap[x, y])
            {
                return HIT_TILE;
            }
            else
            {
                return MISS_TILE;
            }
        }

        public bool hit(int x, int y)
        {
            visibilityMap[x, y] = true;
            return shipMap[x, y];
        }
    }
}