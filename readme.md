# libgfapi-jni

Java Native Interface (JNI) bindings for libgfapi, the GlusterFS client API.

# Usage

This project provides a low level binding from Java to the C language GlusterFS API library.

It was developed as part of [glusterfs-java-filesystem](https://github.com/semiosis/glusterfs-java-filesystem).  Use that 
project to enable GlusterFS support in your Java applications.

# Development Instructions

## Prerequisites

* glusterfs 3.4 or newer - installed from source or a gluster development package installed.
* maven 3.0.3 or newer
* auto tool chain
* Ubuntu packages: build-essential libtool pkg-config automake
* Ubuntu glusterfs PPAs: https://launchpad.net/~gluster  (the glusterfs-common package is required to build this project)

## Compiling without tests

If you have installed gluster to non-standard location then you export `GLFS_HOME` so we know where it's at:

    export GLFS_HOME=/path/to/gluster/prefix

Building without tests is simple.  Just run:

    mvn -Dmaven.test.skip=true install

## Compiling and Testing

The test suite is configured by default to run against the glusterfs server configured in the vagrant box provided by 
glusterfs-java-filesystem.  Run `vagrant up` in that project's root directory to launch the server, then run the tests 
in this project.

Once that server is up, you can run the tests with:

    mvn test

# Project License

Until further notice (made here and in LICENSE.txt) this project is licensed under the terms of the
3-clause BSD license, as written in LICENSE.txt (and copied in several source files).

The licensing is likely to change in the near future as the project matures.