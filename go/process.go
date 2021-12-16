package main

import (
    "bufio"
    "fmt"
    "log"
    "os"
    "strconv"
    "strings"
    "sort"
)

func main() {
    file, err := os.Open(os.Args[1])
    if err != nil {
        log.Fatal(err)
    }
    defer file.Close()

    resultSize, _ := strconv.Atoi(os.Args[2])

    values := make([]int64, resultSize)
    result := make(map[int64]string)
    var minValue int64 = 0
    
    scanner := bufio.NewScanner(file)
    for scanner.Scan() {
        urlValuePair := strings.Split(scanner.Text(), " ")
        if len(urlValuePair) != 2 {
            continue
        }

        url := urlValuePair[0]
        value, _ := strconv.ParseInt(urlValuePair[1], 10, 64)
        //fmt.Printf("%v %v\n", value, url)

        if len(values) < resultSize {
            values = append(values, value)
            result[value] = url
            sort.Slice(values, func(i, j int) bool { return values[i] < values[j] })
            minValue = values[0]
        } else {
            if value > minValue {
                delete(result, minValue)
                result[value] = url
                values = append(values[1:], value)
                sort.Slice(values, func(i, j int) bool { return values[i] < values[j] })
                minValue = values[0]
            }
        }
    }

    fmt.Println(values)

    if err := scanner.Err(); err != nil {
        log.Fatal(err)
    }
}
