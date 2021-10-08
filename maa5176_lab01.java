// Mohammed Ahmed
// 1001655176
// Compiled with java 16 using MacOS

/*

    QUESTIONS:
    
    1. Python was definitely the easiest language to program in for this assignment.
       The fact that I didn't have to worry about small syntax errors (forgetting a semicolon)
       or data types made writing code a whole lot easier. Java was the second easiest, since
       the logic was similar, I just had to add the appropriate data types to my code. Perl was 
       definitely the most challenging, because I had no prior experience using Perl, and figuring
       out the syntax was the biggest challenge for me.



    2. It is possible to write a program that produces the same results without using recursion. 
       This would have to be done by implementing a queue, which would first check all the files
       in the starting directory, and if it found a subdirectory, store the name of the path and 
       check that directory next (Add it to queue). This process would be completed until every
       folder/file was checked. There are a few limitations to this approach, because it would 
       probably be more lines of code, and not as easy to understand compared to simply calling
       the function recursively.
    




*/

import java.io.File;

class maa5176_lab01 
{
    public static void main(String[] args) 
    {
        //variable to store starting directory
        File cwd = new File(".");
        
        // Initializing variable to store total size
        // addFiles will return total size of all files/subdirectories in the file
        long totalSize = addFiles(cwd);

        //Output total size of directory
        System.out.println("\n\nThe total size is: " + totalSize + " bytes\n\n"); 
    }


    // Function that adds all file sizes in directory + all subdirectories
    public static long addFiles(File cwd)
    {

        long totalSize = 0;
        long fileSize;

        //array to store list of files/folders in a directory
        File[] arr = cwd.listFiles();

        //Loops through all files in a directory
        for(File x : arr)
        {
            // Checks if a file is a folder
            if(x.isDirectory())
            {
                
                // Stores size of file
                fileSize = x.length();

                //adding file size to the total
                totalSize += fileSize;

                // Calling function recursively in order to add 
                // file sizes of the subdirectory
                addFiles(x);
            }
            else if(x.isFile()) //checks if x is file
            {
                
                // Stores size of file
                fileSize = x.length();

                //adding file size to the total
                totalSize += fileSize;

            }

        }

        return totalSize; //Returns total size of the directory
    }

}