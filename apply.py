#!/usr/bin/env python
#-*- coding:utf-8 -*-
import sys
import os
import subprocess
import shutil

print "# Stage 1: building...",
sys.stdout.flush()
subprocess.call("ant | tail -n2", shell=True)
print ""
print "finish"

print ""
print "# Stage 2: building javadoc..."
subprocess.call('ant -f "javadoc.xml" | grep "警告"', shell=True)
print "finish"

print "eclipseでjar.jardescをダブルクリックし，jarを生成してください"
raw_input("続けるにはenterを押してください...")

print ""
print "# Stage 3: overwrite jar files..."
workspace = os.path.abspath(os.path.join(os.getcwd(), os.path.pardir))
for project in os.listdir(workspace):
	jarpath = os.path.join(os.path.dirname(__file__), os.path.pardir, project, "jars", "rioneviewer.jar")
	if os.path.exists(jarpath):
		shutil.copyfile("rioneviewer.jar", jarpath)
		print jarpath + "を書き換えました"

print "編集中であればeclipseで適用したプロジェクトを更新(F5)してください．"
print "finish"

