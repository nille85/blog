#!/bin/bash
# Amazon deploy script

echo "Starting deploy script"

ls -a /tmp/ssh/

ssh -i "/tmp/ssh/AmazonNille" ubuntu@ec2-54-244-108-16.us-west-2.compute.amazonaws.com "bash -s $(echo "Hello from Amazon VM")"

echo "Ending deploy script"