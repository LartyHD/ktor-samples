[![official JetBrains project](https://jb.gg/badges/official-flat-square.svg)](https://confluence.jetbrains.com/display/ALL/JetBrains+on+GitHub)

# GraalVM sample for Ktor Server

A demo project that shows how to combine Ktor Server applications with GraalVM.

## Steps

1. Make sure that you have [GraalVM](https://graalvm.org) installed and `$GRAALVM_HOME` environment
variable points to the folder where GraalVM is installed, or alternatively that `native-image` is on your path (if on Windows). 
   
2. Build the project by executing the task `shadowJar` which will build and produce a fat jar containing
all the necessary dependencies.
   
3. Run the file `build.sh` if on Linux or macOS, or `build.cmd` if on Windows.

4. The previous step produces an executable file named `graal-server` which can then be run. Open up
`https://0.0.0.0:8080` to test the server.
   
### Current limitations

Using the `Netty` engine is not compatible with GraalVM. Please following the [corresponding issue](https://youtrack.jetbrains.com/issue/KTOR-2558) for
updates.

## License

This sample is provided as is under the Apache 2 OSS license. 

