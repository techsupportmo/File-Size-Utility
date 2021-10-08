# Mohammed Ahmed
# 1001655176
# Compiled with perl 5 Version 30 using MacOS



use warnings;
use diagnostics;
use Cwd;



# Function to add size of files in directory
sub add_files
{

    # stores current (starting) directory
    my ($current_directory) = @_;

    # Initialize total size
    # This will store the sum of all the file sizes
    $total_size = 0;

    # This array stores all of the files/folders in the current directory
    my @arr = glob($current_directory);


    # Loops through all files in a directory
    foreach( @arr )
    {
          

        # Checks if file is a directory
        if(-d $_)
        {

            # Adds size of file to the total
            $total_size += -s $_;

            # Calls function to add files in subdirectory
            add_files("$_/*")
        }

        # Checks if the array element is a file
        if(-f $_)
        {

            # Adds size of file to the total
            $total_size += -s $_;

        }

    }



    return ($total_size); # Returns total size of the directory
}


# stores current (starting) directory
my $cwd = getcwd();

# Stores entire path
$cwd = "$cwd/*";

# Initializing total variable to store total size
# add_files will return total size of all files/subdirectories in the file
my $total = add_files($cwd);

# Output total
print "\nThe total size is: $total bytes\n\n";



