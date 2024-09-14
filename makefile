# Define variables
SRC_DIR = src/main/java
BIN_DIR = bin
MAIN_CLASS = com.student_info_processor.MyApp

# Ensure that the JAVA_HOME environment is java-21-openjdk (consistency of javac and java)
JAVA_HOME = /usr
JAVAC = $(JAVA_HOME)/bin/javac
JAVA = $(JAVA_HOME)/bin/java

# Find all .java source files in the SRC_DIR directory and its subdirectories
SOURCES := $(shell find $(SRC_DIR) -type f -name "*.java")

# Convert .java source files to .class files in the BIN_DIR, while preserving package structure
CLASSES := $(SOURCES:$(SRC_DIR)/%.java=$(BIN_DIR)/%.class)

# Default target: build the project
.PHONY: all
all: build

# Target to build the project
build: $(CLASSES)

# Compile all .java files to .class files, maintaining the package structure
$(BIN_DIR)/%.class: $(SRC_DIR)/%.java
	@mkdir -p $(dir $@)  # Create the necessary directory structure in the bin directory
	$(JAVAC) -d $(BIN_DIR) -sourcepath $(SRC_DIR) $<  # Compile the source file into the bin directory

# Target to run the project
.PHONY: run
run: build
	$(JAVA) -cp $(BIN_DIR) $(MAIN_CLASS)

# Target to clean compiled files
.PHONY: clean
clean:
	rm -rf $(BIN_DIR)

# Target to clean and build the project
.PHONY: rebuild
rebuild: clean all