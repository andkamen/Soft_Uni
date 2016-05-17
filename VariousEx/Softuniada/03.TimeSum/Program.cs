using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Globalization;

namespace _03.TimeSum
{
    class Program
    {
        static void Main(string[] args)
        {
            string format1 = "d::H:mm";
            string format2 = "H:mm";
            CultureInfo provider = CultureInfo.InvariantCulture;

            string date1 = Console.ReadLine();
            string date2 = Console.ReadLine();

            DateTime t1, t2;
            bool date1Parsed;
            bool date2Parsed;

            date1Parsed = DateTime.TryParseExact(date1, format2, provider, DateTimeStyles.None,out t1);
            if (!date1Parsed)
            {
                t1 = DateTime.ParseExact(date1, format1, provider);
            }
            date1Parsed = DateTime.TryParseExact(date2, format2, provider, DateTimeStyles.None, out t2);
            if (!date1Parsed)
            {
                t2 = DateTime.ParseExact(date2, format1, provider);
            }
          //  Console.WriteLine("{0:H\\:mm}", t1);
         //   Console.WriteLine("{0:H\\:mm}", t2);

            DateTime result = t1.Add(t2.TimeOfDay);

            // Console.WriteLine("{0:d\\:\\:h\\:mm}",result);
            if (result.Day == DateTime.Now.Day)
            {
                Console.WriteLine("{0:H\\:mm}", result);

            }
            else
            {
                result = result.AddDays(-9);
                Console.WriteLine("{0:d\\:\\:H\\:mm}", result);

            }


        }
    }
}
