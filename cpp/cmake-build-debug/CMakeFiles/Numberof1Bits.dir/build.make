# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.7

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /Applications/CLion.app/Contents/bin/cmake/bin/cmake

# The command to remove a file.
RM = /Applications/CLion.app/Contents/bin/cmake/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/Numberof1Bits.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/Numberof1Bits.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/Numberof1Bits.dir/flags.make

CMakeFiles/Numberof1Bits.dir/Numberof1Bits.cpp.o: CMakeFiles/Numberof1Bits.dir/flags.make
CMakeFiles/Numberof1Bits.dir/Numberof1Bits.cpp.o: ../Numberof1Bits.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/Numberof1Bits.dir/Numberof1Bits.cpp.o"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++   $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/Numberof1Bits.dir/Numberof1Bits.cpp.o -c /Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp/Numberof1Bits.cpp

CMakeFiles/Numberof1Bits.dir/Numberof1Bits.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/Numberof1Bits.dir/Numberof1Bits.cpp.i"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp/Numberof1Bits.cpp > CMakeFiles/Numberof1Bits.dir/Numberof1Bits.cpp.i

CMakeFiles/Numberof1Bits.dir/Numberof1Bits.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/Numberof1Bits.dir/Numberof1Bits.cpp.s"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp/Numberof1Bits.cpp -o CMakeFiles/Numberof1Bits.dir/Numberof1Bits.cpp.s

CMakeFiles/Numberof1Bits.dir/Numberof1Bits.cpp.o.requires:

.PHONY : CMakeFiles/Numberof1Bits.dir/Numberof1Bits.cpp.o.requires

CMakeFiles/Numberof1Bits.dir/Numberof1Bits.cpp.o.provides: CMakeFiles/Numberof1Bits.dir/Numberof1Bits.cpp.o.requires
	$(MAKE) -f CMakeFiles/Numberof1Bits.dir/build.make CMakeFiles/Numberof1Bits.dir/Numberof1Bits.cpp.o.provides.build
.PHONY : CMakeFiles/Numberof1Bits.dir/Numberof1Bits.cpp.o.provides

CMakeFiles/Numberof1Bits.dir/Numberof1Bits.cpp.o.provides.build: CMakeFiles/Numberof1Bits.dir/Numberof1Bits.cpp.o


# Object files for target Numberof1Bits
Numberof1Bits_OBJECTS = \
"CMakeFiles/Numberof1Bits.dir/Numberof1Bits.cpp.o"

# External object files for target Numberof1Bits
Numberof1Bits_EXTERNAL_OBJECTS =

Numberof1Bits: CMakeFiles/Numberof1Bits.dir/Numberof1Bits.cpp.o
Numberof1Bits: CMakeFiles/Numberof1Bits.dir/build.make
Numberof1Bits: CMakeFiles/Numberof1Bits.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable Numberof1Bits"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/Numberof1Bits.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/Numberof1Bits.dir/build: Numberof1Bits

.PHONY : CMakeFiles/Numberof1Bits.dir/build

CMakeFiles/Numberof1Bits.dir/requires: CMakeFiles/Numberof1Bits.dir/Numberof1Bits.cpp.o.requires

.PHONY : CMakeFiles/Numberof1Bits.dir/requires

CMakeFiles/Numberof1Bits.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/Numberof1Bits.dir/cmake_clean.cmake
.PHONY : CMakeFiles/Numberof1Bits.dir/clean

CMakeFiles/Numberof1Bits.dir/depend:
	cd /Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp /Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp /Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp/cmake-build-debug /Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp/cmake-build-debug /Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp/cmake-build-debug/CMakeFiles/Numberof1Bits.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/Numberof1Bits.dir/depend

