import groovy.json.StreamingJsonBuilder

log = System.err.&println

def destroy(options) {
    log "destroy()"
}
def parse(options) {
    if (options.arguments().size() != 1) {
        log "Must specify a single file to read"
        return
    }
    def filename = options.arguments()[0]

    def config = readConfig(options.c)
    def sep = readSeparator(options)
    log "parsing $filename using separator $sep"
    def file = new File(filename)
    def header
    def writer = new PrintWriter(System.out)
    def builder = new StreamingJsonBuilder(writer)
    writer.append("[")
    file.eachLine() { line, i ->
        if (i == 1) { // header line
            header = line.split(sep)
            return
        } else if (i > 2) { // not the first data line
            writer.append(",")
        }
        def categories = [:]
        def results = [:]
        //println "LINE: $it\n\n"
        line.split(sep).eachWithIndex { String entry, int j ->
            if (entry) {
                def h = header[j]
                def type = config.fields[h]?.type
                def name = config.fields[h]?.name ?: h
                def category = config.fields[h]?.category
                def map
                if (category) {
                    map = categories[category]
                    if (map == null) {
                        map = [:]
                        categories[category] = map
                    }
                } else {
                    map = results
                }
                //println "$i $h $type $entry"
                map[(name)] = (type == null ? entry : type.getConstructor(String.class).newInstance(entry))
            }
        }
        results.putAll(categories)

        builder.call(results)
    }
    writer.append("]")
    writer.flush()
}

def readConfig(file) {
    return  new ConfigSlurper().parse(new File(file).toURI().toURL());
}

def readSeparator(options) {
    return options.s ?: /\t/
}

def cli = new CliBuilder(usage: 'parser.groovy -m <mode> -c <config> [-s <separator>] -[h] file')
// Create the list of options.
cli.with {
    h longOpt: 'help', 'Show usage information'
    m longOpt: 'mode', args:1, argName:'mode', 'Main method to run'
    c longOpt: 'config', args:1, argName:'config', 'Configuration file'
    s longOpt: 'separator', args:1, argName:'separator', 'Separator in data file (default tab)'
}

def options = cli.parse(args)
if (!options) {
    return
}
// Show usage text when -h or --help option is used.
if (options.h) {
    cli.usage()
    return
}

if (options.m) {
    "${options.m}"(options)
} else {
    log "No mode specified"
    cli.usage()
}
