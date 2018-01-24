# Data Examples

This directory contains examples of datasets that will be annotated using the approaches defined by ORN.
Each directory handles a different dataset.

## Parser

[parser.groovy](parser.groovy)  is a quick and dirty parser (written in Groovy) that is present in this directory. 
It allows parsing of csv or tsv format data into JSON allowing some limited processing and restructuring of 
the data. See the individual datasets for typical usage.

Run like this:

```
groovy parser.groovy -c <config-file> -m parse <tsv-file>
```

For all the options run this:
```
$ groovy parser.groovy -h
usage: parser.groovy -m <mode> -c <config> [-s <separator>] -[h] file
 -c,--config <config>         Configuration file
 -h,--help                    Show usage information
 -m,--mode <mode>             Main method to run
 -s,--separator <separator>   Separator in data file (default tab)
```

The -c argument is used to specify a configuration file that determines how the data is handled (the config 
file is loaded by the Groovy 
[ConfigSlurper class](http://docs.groovy-lang.org/latest/html/gapi/groovy/util/ConfigSlurper.html)).
  
