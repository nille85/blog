#!/bin/bash


#add java 8 repository
sudo add-apt-repository ppa:webupd8team/java

#import mongoDB public GPG Key
sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 0C49F3730359A14518585931BC711F9BA15703C6


# create mongoDB sources list
echo "deb [ arch=amd64 ] http://repo.mongodb.org/apt/ubuntu trusty/mongodb-org/3.4 multiverse" | sudo tee /etc/apt/sources.list.d/mongodb-org-3.4.list


#reload local package database
sudo apt-get update


#install java 8
sudo apt-get install oracle-java8-installer

#install mongoDB
sudo apt-get install -y mongodb-org
