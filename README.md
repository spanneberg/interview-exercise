# Generate test data

Note: Generating large files can take some time!

```
cd testdata
./generate.sh 10 10-items.txt
./generate.sh 100 100-items.txt
./generate.sh 1000 1000-items.txt
./generate.sh 10000 10000-items.txt
./generate.sh 100000 100000-items.txt
./generate.sh 1000000 1000000-items.txt
./generate.sh 10000000 10000000-items.txt
./generate.sh 100000000 100000000-items.txt
```

# Bash implementation

```
cd bash
./run ../testdata/1000-items.txt 10
```

# Java implementation

```
cd java
./run ../testdata/1000-items.txt 10
```

# Go implementation

```
cd go
./run ../testdata/1000-items.txt 10
```
