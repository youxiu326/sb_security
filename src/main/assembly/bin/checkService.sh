#!/bin/bash
cd `dirname $0`
BIN_DIR=`pwd`
cd ..
DEPLOY_DIR=`pwd`

    COUNT=`ps -fe |grep nginx | grep -v grep | wc -l`
	echo $COUNT
    if [ $COUNT -lt 1 ]; then
       	/sbin/service nginx restart
    fi
    

    COUNT=0
    COUNT=`ps -fe |grep java | grep "$DEPLOY_DIR" | grep -v grep | wc -l`
	echo $COUNT
    if [ $COUNT -gt 1 ]; then
        /sbin/service mall_website_service restart
    fi

