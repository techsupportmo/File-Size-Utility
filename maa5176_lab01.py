# Mohammed Ahmed
# 1001655176
# Compiled with python 3.9.1 using MacOS

import os.path

# Function that adds all file sizes in directory + all subdirectories
def list_files(cwd):

  # Variable that will store total file sizes
  totalSize = 0

  # store contents of current directory in an array
  arr = os.listdir(cwd)
      
  # Loops through all files in a directory
  for x in arr:

    # Stores the path of next directory
    next_cwd = os.path.join(cwd, x)

    

    # Checks if a file is a folder
    if os.path.isdir(x): 
        
        # stores size of file
        file_size = os.path.getsize(x)

        # adds the directory size to the total
        totalSize += file_size

        # Add up file sizes in subdirectory using recursion
        list_files(next_cwd)

    elif os.path.isfile(next_cwd):

        # stores size of file
        file_size = os.path.getsize(x)

        # adds file size to total
        totalSize += file_size

  return totalSize     # Returns total size of the directory
        
# Get the current working directory (starting directory)
cwd = os.getcwd()

# Calling function to list files
totalSize = list_files(cwd)

# Prints the total size
print("\n\nThe total size is: %d bytes\n" %totalSize)