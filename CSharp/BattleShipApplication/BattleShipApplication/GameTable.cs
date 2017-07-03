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

        public void placeShip(int length)
        {
            Random rand = new Random();
            bool orientation;
            int posX, posY;
            do
            {
                orientation = (rand.Next() % 2 == 0);
                posX = rand.Next(0, 20);
                posY = rand.Next(0, 20);
                if (orientation == true && (posX + length >= 20))
                {
                    posX -= length;
                } 
                else if (posY + length >= 20)
                {
                    posY -= length;
                }
            } while (!posValid(posX, posY, orientation, length));
            setupShip(posX, posY, orientation, length);
        }

        private bool posValid(int posX, int posY, bool orientation, int length)
        {
            for (int i = -1; i <= length; i++)
                for (int j = -1; j <= 1; j++)
                {
                    if (orientation)
                    {
                        if (posX + i < 20 && posX + i >= 0 && posY + j < 20 && posY + j >= 0)
                            if (shipMap[posX + i, posY + j] == true)
                            {
                                return false;
                            }
                    }
                    else
                    {
                        if (posX + j < 20 && posX + j >= 0 && posY + i < 20 && posY + i >= 0)
                            if (shipMap[posX + j, posY + i] == true)
                            {
                                return false;
                            }
                    }
                }
            return true;
        }

        private void setupShip(int posX, int posY, bool orientation, int length)
        {
            for (int i = 0; i < length; i++)
            {
                if (orientation)
                {
                    shipMap[posX + i, posY] = true;
                }
                else
                {
                    shipMap[posX, posY + i] = true;
                }
            }
        }

        public bool hit(int x, int y)
        {
            if (visibilityMap[x, y])
                return false;
            visibilityMap[x, y] = true;
            return shipMap[x, y];
        }

        public void init()
        {
            placeShip(8);
            placeShip(5);
            placeShip(5);
            placeShip(3);
            placeShip(3);
            placeShip(3);
            placeShip(2);
            placeShip(2);
            placeShip(2);
            placeShip(1);
            placeShip(1);
            placeShip(1);
            placeShip(1);
        }

        public void printMap()
        {
            char letter = 'A';
            Console.Write("     ");
            for (int i = 0; i < 20; i++)
            {
                Console.Write("{0} ", (char)(letter + i));
            }
            Console.WriteLine();
            for (int i = 0; i < 20; i++)
            {
                Console.Write("{0,3}: ",i+1);
                for (int j = 0; j < 20; j++)
                {
                    Console.Write(getTile(j, i) + " ");
                }
                Console.WriteLine();                
            }
        }
    }
}