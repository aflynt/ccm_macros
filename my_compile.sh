#!/usr/bin/bash

DIR=$1
FNAME=$2

cmd="$JCOMPILER -classpath $JCLASSPATH -d $DIR $DIR/$FNAME"

echo $cmd
$cmd

