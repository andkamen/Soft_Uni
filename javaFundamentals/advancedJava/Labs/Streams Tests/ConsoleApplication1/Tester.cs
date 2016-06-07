namespace SimpleJudge
{
    using System;
    using System.IO;

    public static class Tester
    {
        public static void Test(string userOutputPath, string expectedOutputPath)
        {
            Console.WriteLine("Reading files...");

            string mismatchPath = GetMismatchPath(expectedOutputPath);

            using (File.Create(mismatchPath)) ;
            string[] input = File.ReadAllLines(userOutputPath);
            string[] expectedOutput = File.ReadAllLines(expectedOutputPath);


            bool mismatch = false;
            int mismatchCount = 0;
            Console.WriteLine("Comparing items...");
            //File.OpenWrite(mismatchPath);
            var writer = File.AppendText(mismatchPath);

            using (writer)
            {
                for (int i = 0; i < input.Length; i++)
                {
                    try
                    {
                        string currentItem = input[i];
                        string expectedItem = expectedOutput[i];
                        if (currentItem != expectedItem)
                        {
                            mismatch = true;
                            mismatchCount++;
                            writer.WriteLine("!!!MISMATCH!!! Expected >>>{0}<<< was >>>{1}<<<", expectedItem, currentItem);
                            
                        }
                        else
                        {
                            writer.WriteLine(currentItem);
                        }
                    }
                    catch (IndexOutOfRangeException e)
                    {
                        Console.WriteLine("Files not of equal size, certain mismatch");
                        return;
                    }

                }
            }
            Console.WriteLine("Comparison complete.");
            if (mismatch)
            {
                Console.ForegroundColor = ConsoleColor.Red;
                Console.WriteLine("{0} mismatches detected", mismatchCount);
                Console.ForegroundColor = ConsoleColor.Yellow;
                Console.WriteLine("Report of mismatches at {0}", mismatchPath);

            }
            else
            {
                Console.ForegroundColor = ConsoleColor.Green;
                Console.WriteLine("Files are identical");
                Console.ForegroundColor = ConsoleColor.Yellow;
                File.Delete(mismatchPath);
            }
        }

        private static string GetMismatchPath(string expectedOutputPath)
        {
            int indexOf = expectedOutputPath.LastIndexOf('\\');
            string directoryPath = expectedOutputPath.Substring(0, indexOf);
            string finalPath = directoryPath + @"\Mismatches.txt";
            return finalPath;
        }
    }
}
