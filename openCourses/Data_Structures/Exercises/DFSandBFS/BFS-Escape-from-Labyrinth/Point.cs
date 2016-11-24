using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Escape_from_Labyrinth
{
    public class Point
    {
        public Point(int x, int y, string direction=null, Point previousPoint=null)
        {
            this.X = x;
            this.Y = y;
            this.Direction = direction;
            this.PreviousPoint = previousPoint;
        }
        
        public int X { get; set; }
        public int Y { get; set; }

        public string Direction { get; set; }

        public Point PreviousPoint { get; set; }
    }
}
