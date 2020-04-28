# Host: localhost  (Version: 5.5.34)
# Date: 2020-04-27 22:59:54
# Generator: MySQL-Front 5.3  (Build 3.22)

/*!40101 SET NAMES utf8 */;

CREATE DATABASE `evs` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `evs`;

#
# Source for table "evs_tbl_election"
#

CREATE TABLE `evs_tbl_election` (
  `electionid` varchar(6) NOT NULL DEFAULT '',
  `name` varchar(15) NOT NULL DEFAULT '',
  `electiondate` date NOT NULL DEFAULT '0000-00-00',
  `district` varchar(15) NOT NULL DEFAULT '',
  `constituency` varchar(15) NOT NULL DEFAULT '',
  `countingdate` date DEFAULT '0000-00-00',
  PRIMARY KEY (`electionid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Source for table "evs_tbl_eo"
#

CREATE TABLE `evs_tbl_eo` (
  `electoralofficeid` varchar(6) NOT NULL DEFAULT '',
  `consituency` varchar(25) NOT NULL DEFAULT '',
  PRIMARY KEY (`electoralofficeid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Source for table "evs_tbl_party"
#

CREATE TABLE `evs_tbl_party` (
  `partyid` varchar(6) NOT NULL DEFAULT '',
  `name` varchar(20) NOT NULL DEFAULT '',
  `leader` varchar(20) NOT NULL DEFAULT '',
  `symbol` varchar(40) NOT NULL DEFAULT '',
  PRIMARY KEY (`partyid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Source for table "evs_tbl_candidate"
#

CREATE TABLE `evs_tbl_candidate` (
  `candidateid` varchar(6) NOT NULL DEFAULT '',
  `name` varchar(20) NOT NULL DEFAULT '',
  `electionid` varchar(6) NOT NULL DEFAULT '',
  `partyid` varchar(6) NOT NULL DEFAULT '',
  `district` varchar(20) NOT NULL DEFAULT '',
  `contituency` varchar(20) NOT NULL DEFAULT '',
  `dateofbirth` date NOT NULL DEFAULT '0000-00-00',
  `mobileno` varchar(10) NOT NULL DEFAULT '',
  `address` varchar(50) NOT NULL DEFAULT '',
  `emailid` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`candidateid`),
  KEY `evs_tbl_candidate_fk` (`electionid`),
  KEY `evs_tbl_candidate_fk_1` (`partyid`),
  CONSTRAINT `evs_tbl_candidate_fk_1` FOREIGN KEY (`partyid`) REFERENCES `evs_tbl_party` (`partyid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `evs_tbl_candidate_fk` FOREIGN KEY (`electionid`) REFERENCES `evs_tbl_election` (`electionid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Source for table "evs_tbl_result"
#

CREATE TABLE `evs_tbl_result` (
  `serialno` decimal(6,0) unsigned NOT NULL DEFAULT '0',
  `electionid` varchar(6) NOT NULL DEFAULT '',
  `candidateid` varchar(6) NOT NULL DEFAULT '',
  `votecount` decimal(5,0) unsigned DEFAULT NULL,
  PRIMARY KEY (`serialno`),
  KEY `evs_tbl_result_fk` (`candidateid`),
  KEY `evs_tbl_result_fk_1` (`electionid`),
  CONSTRAINT `evs_tbl_result_fk_1` FOREIGN KEY (`electionid`) REFERENCES `evs_tbl_election` (`electionid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `evs_tbl_result_fk` FOREIGN KEY (`candidateid`) REFERENCES `evs_tbl_candidate` (`candidateid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Source for table "evs_tbl_user_credentials"
#

CREATE TABLE `evs_tbl_user_credentials` (
  `userid` varchar(6) NOT NULL DEFAULT '',
  `password` varchar(20) NOT NULL DEFAULT '',
  `usertype` varchar(1) NOT NULL DEFAULT '',
  `loginstatus` decimal(1,0) unsigned DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Source for table "evs_tbl_application"
#

CREATE TABLE `evs_tbl_application` (
  `userid` varchar(6) NOT NULL DEFAULT '',
  `consituency` varchar(20) NOT NULL DEFAULT '',
  `passedstatus` decimal(2,0) unsigned NOT NULL DEFAULT '0',
  `aprrovedstatus` decimal(2,0) unsigned NOT NULL DEFAULT '0',
  `voterid` varchar(8) NOT NULL DEFAULT '',
  PRIMARY KEY (`userid`),
  CONSTRAINT `evs_tbl_application_fk` FOREIGN KEY (`userid`) REFERENCES `evs_tbl_user_credentials` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Source for table "evs_tbl_user_profile"
#

CREATE TABLE `evs_tbl_user_profile` (
  `userid` varchar(6) NOT NULL DEFAULT '',
  `firstname` varchar(15) NOT NULL DEFAULT '',
  `lastname` varchar(15) DEFAULT '',
  `dateofbirth` date DEFAULT NULL,
  `gender` varchar(7) NOT NULL DEFAULT '',
  `street` varchar(30) NOT NULL DEFAULT '',
  `location` varchar(15) NOT NULL DEFAULT '',
  `city` varchar(15) NOT NULL DEFAULT '',
  `state` varchar(15) NOT NULL DEFAULT '',
  `pincode` varchar(10) NOT NULL DEFAULT '',
  `mobileno` varchar(10) NOT NULL DEFAULT '',
  `emailid` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`userid`),
  CONSTRAINT `evs_tbl_user_profile_fk` FOREIGN KEY (`userid`) REFERENCES `evs_tbl_user_credentials` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Source for table "evs_tbl_voter_details"
#

CREATE TABLE `evs_tbl_voter_details` (
  `serialno` decimal(6,0) unsigned NOT NULL DEFAULT '0',
  `candidateid` varchar(6) NOT NULL DEFAULT '',
  `electionid` varchar(6) NOT NULL DEFAULT '',
  `voterid` varchar(8) NOT NULL DEFAULT '',
  PRIMARY KEY (`serialno`),
  KEY `evs_tbl_voter_details_fk` (`electionid`),
  KEY `evs_tbl_voter_details_fk_1` (`candidateid`),
  CONSTRAINT `evs_tbl_voter_details_fk_1` FOREIGN KEY (`candidateid`) REFERENCES `evs_tbl_candidate` (`candidateid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `evs_tbl_voter_details_fk` FOREIGN KEY (`electionid`) REFERENCES `evs_tbl_election` (`electionid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
