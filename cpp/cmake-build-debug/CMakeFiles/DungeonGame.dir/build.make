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
include CMakeFiles/DungeonGame.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/DungeonGame.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/DungeonGame.dir/flags.make

CMakeFiles/DungeonGame.dir/DungeonGame.cpp.o: CMakeFiles/DungeonGame.dir/flags.make
CMakeFiles/DungeonGame.dir/DungeonGame.cpp.o: ../DungeonGame.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/DungeonGame.dir/DungeonGame.cpp.o"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++   $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/DungeonGame.dir/DungeonGame.cpp.o -c /Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp/DungeonGame.cpp

CMakeFiles/DungeonGame.dir/DungeonGame.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/DungeonGame.dir/DungeonGame.cpp.i"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp/DungeonGame.cpp > CMakeFiles/DungeonGame.dir/DungeonGame.cpp.i

CMakeFiles/DungeonGame.dir/DungeonGame.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/DungeonGame.dir/DungeonGame.cpp.s"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp/DungeonGame.cpp -o CMakeFiles/DungeonGame.dir/DungeonGame.cpp.s

CMakeFiles/DungeonGame.dir/DungeonGame.cpp.o.requires:

.PHONY : CMakeFiles/DungeonGame.dir/DungeonGame.cpp.o.requires

CMakeFiles/DungeonGame.dir/DungeonGame.cpp.o.provides: CMakeFiles/DungeonGame.dir/DungeonGame.cpp.o.requires
	$(MAKE) -f CMakeFiles/DungeonGame.dir/build.make CMakeFiles/DungeonGame.dir/DungeonGame.cpp.o.provides.build
.PHONY : CMakeFiles/DungeonGame.dir/DungeonGame.cpp.o.provides

CMakeFiles/DungeonGame.dir/DungeonGame.cpp.o.provides.build: CMakeFiles/DungeonGame.dir/DungeonGame.cpp.o


CMakeFiles/DungeonGame.dir/LargestNumber.cpp.o: CMakeFiles/DungeonGame.dir/flags.make
CMakeFiles/DungeonGame.dir/LargestNumber.cpp.o: ../LargestNumber.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object CMakeFiles/DungeonGame.dir/LargestNumber.cpp.o"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++   $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/DungeonGame.dir/LargestNumber.cpp.o -c /Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp/LargestNumber.cpp

CMakeFiles/DungeonGame.dir/LargestNumber.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/DungeonGame.dir/LargestNumber.cpp.i"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp/LargestNumber.cpp > CMakeFiles/DungeonGame.dir/LargestNumber.cpp.i

CMakeFiles/DungeonGame.dir/LargestNumber.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/DungeonGame.dir/LargestNumber.cpp.s"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp/LargestNumber.cpp -o CMakeFiles/DungeonGame.dir/LargestNumber.cpp.s

CMakeFiles/DungeonGame.dir/LargestNumber.cpp.o.requires:

.PHONY : CMakeFiles/DungeonGame.dir/LargestNumber.cpp.o.requires

CMakeFiles/DungeonGame.dir/LargestNumber.cpp.o.provides: CMakeFiles/DungeonGame.dir/LargestNumber.cpp.o.requires
	$(MAKE) -f CMakeFiles/DungeonGame.dir/build.make CMakeFiles/DungeonGame.dir/LargestNumber.cpp.o.provides.build
.PHONY : CMakeFiles/DungeonGame.dir/LargestNumber.cpp.o.provides

CMakeFiles/DungeonGame.dir/LargestNumber.cpp.o.provides.build: CMakeFiles/DungeonGame.dir/LargestNumber.cpp.o


# Object files for target DungeonGame
DungeonGame_OBJECTS = \
"CMakeFiles/DungeonGame.dir/DungeonGame.cpp.o" \
"CMakeFiles/DungeonGame.dir/LargestNumber.cpp.o"

# External object files for target DungeonGame
DungeonGame_EXTERNAL_OBJECTS =

DungeonGame: CMakeFiles/DungeonGame.dir/DungeonGame.cpp.o
DungeonGame: CMakeFiles/DungeonGame.dir/LargestNumber.cpp.o
DungeonGame: CMakeFiles/DungeonGame.dir/build.make
DungeonGame: CMakeFiles/DungeonGame.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Linking CXX executable DungeonGame"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/DungeonGame.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/DungeonGame.dir/build: DungeonGame

.PHONY : CMakeFiles/DungeonGame.dir/build

CMakeFiles/DungeonGame.dir/requires: CMakeFiles/DungeonGame.dir/DungeonGame.cpp.o.requires
CMakeFiles/DungeonGame.dir/requires: CMakeFiles/DungeonGame.dir/LargestNumber.cpp.o.requires

.PHONY : CMakeFiles/DungeonGame.dir/requires

CMakeFiles/DungeonGame.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/DungeonGame.dir/cmake_clean.cmake
.PHONY : CMakeFiles/DungeonGame.dir/clean

CMakeFiles/DungeonGame.dir/depend:
	cd /Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp /Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp /Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp/cmake-build-debug /Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp/cmake-build-debug /Users/zhun.qu/Documents/codes/Cuero/leetcode/cpp/cmake-build-debug/CMakeFiles/DungeonGame.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/DungeonGame.dir/depend

