package com.newgen.iforms.user;

public class XMLParser {
    private String parseString;
    private String copyString;
    private int indexOfPrevSrch;

    public XMLParser() {
    }

    public XMLParser(String parseThisString) {
        copyString=parseThisString;
        parseString = toUpperCase(copyString);
    }

    public void setInputXML(String parseThisString) {
        if (parseThisString != null) {
        	copyString=parseThisString;
            parseString = toUpperCase(copyString);
            indexOfPrevSrch = 0;
        } else {
            parseString = null;
            copyString = null;
            indexOfPrevSrch = 0;
        }
    }

    public String getServiceName() {
       
            return copyString.substring(parseString.indexOf(
                    toUpperCase(
                            "<Option>")) +
                    (toUpperCase("<Option>")).length(),
                    parseString.indexOf(toUpperCase(
                            "</Option>")));
       
    }

    public String getServiceName(char chr) {
        try {
            if (chr == 'A') {
                return copyString.substring(parseString.indexOf(
                        "<AdminOption>".toUpperCase()) +
                        ("<AdminOption>".
                                    toUpperCase()).length(),
                        parseString.indexOf(
                                "</AdminOption>".toUpperCase()));
            } else {
                return "";
            }
        } catch (StringIndexOutOfBoundsException
                 stringindexoutofboundsexception) {
            return "NoServiceFound";
        }
    }

    public boolean validateXML() {
        try {
            return parseString.indexOf("<?xml version=\"1.0\"?>".toUpperCase()) !=
                    -1;
        } catch (StringIndexOutOfBoundsException
                 stringindexoutofboundsexception) {
            return false;
        }
    }

    public String getValueOf(String valueOf) {
        try {
            return copyString.substring(parseString.indexOf("<" +
                    toUpperCase(valueOf) + ">") + valueOf.length() + 2,
                    parseString.
                    indexOf("</" +
                            toUpperCase(valueOf) + ">"));
        } catch (StringIndexOutOfBoundsException
                 stringindexoutofboundsexception) {
            return "";
        }
    }

    public String getValueOf(String valueOf, String type) {
        try {
            if (type.equalsIgnoreCase("Binary")) {
                int startPos = copyString.indexOf("<" + valueOf + ">");
                if (startPos == -1) {
                    return "";
                } else {
                    int endPos = copyString.lastIndexOf("</" + valueOf + ">");
                    startPos += ("<" + valueOf + ">").length();
                    return copyString.substring(startPos, endPos);
                }
            } else {
                return "";
            }
        } catch (StringIndexOutOfBoundsException
                 stringindexoutofboundsexception) {
            return "";
        }
    }

    public String getValueOf(String valueOf, boolean fromlast) {
        try {
            if (fromlast) {
                return copyString.substring(parseString.indexOf("<" +
                        toUpperCase(valueOf) + ">") + valueOf.length() +
                        2,
                        parseString.lastIndexOf("</" +
                                                toUpperCase(valueOf) +
                                                ">"));
            } else {
                return copyString.substring(parseString.indexOf("<" +
                        toUpperCase(valueOf) + ">") + valueOf.length() +
                        2,
                        parseString.indexOf("</" +
                                            toUpperCase(valueOf) + ">"));
            }
        } catch (StringIndexOutOfBoundsException
                 stringindexoutofboundsexception) {
            return "";
        }
    }

    public String getValueOf(String valueOf, int start, int end) {
        try {
            if (start >= 0) {
                int endIndex = parseString.indexOf("</" +
                        toUpperCase(valueOf) +
                        ">", start);
                if (endIndex > start && (end == 0 || end >= endIndex)) {
                    return copyString.substring(parseString.indexOf(
                            "<" +
                            toUpperCase(valueOf) + ">", start) +
                            valueOf.length() + 2,
                            endIndex);
                }
            }
            return "";
        } catch (StringIndexOutOfBoundsException
                 stringindexoutofboundsexception) {
            return "";
        }
    }

    public int getStartIndex(String tag, int start, int end) {
        try {
            if (start >= 0) {
                int startIndex = parseString.indexOf("<" +
                        toUpperCase(tag) + ">",
                        start);
                if (startIndex >= start && (end == 0 || end >= startIndex)) {
                    return startIndex + tag.length() + 2;
                }
            }
            return -1;
        } catch (StringIndexOutOfBoundsException
                 stringindexoutofboundsexception) {
            return -1;
        }
    }

    public int getEndIndex(String tag, int start, int end) {
        try {
            if (start >= 0) {
                int endIndex = parseString.indexOf("</" + toUpperCase(tag) +
                        ">",
                        start);
                if (endIndex > start && (end == 0 || end >= endIndex)) {
                    return endIndex;
                }
            }
            return -1;
        } catch (StringIndexOutOfBoundsException
                 stringindexoutofboundsexception) {
            return -1;
        }
    }

    public int getTagStartIndex(String tag, int start, int end) {
        try {
            if (start >= 0) {
                int startIndex = parseString.indexOf("<" +
                        toUpperCase(tag) + ">",
                        start);
                if (startIndex >= start && (end == 0 || end >= startIndex)) {
                    return startIndex;
                }
            }
            return -1;
        } catch (StringIndexOutOfBoundsException
                 stringindexoutofboundsexception) {
            return -1;
        }
    }

    public int getTagEndIndex(String tag, int start, int end) {
        try {
            if (start >= 0) {
                int endIndex = parseString.indexOf("</" + toUpperCase(tag) +
                        ">",
                        start);
                if (endIndex > start && (end == 0 || end >= endIndex)) {
                    return endIndex + tag.length() + 3;
                }
            }
            return -1;
        } catch (StringIndexOutOfBoundsException
                 stringindexoutofboundsexception) {
            return -1;
        }
    }

    public String getFirstValueOf(String valueOf) {
        try {
            indexOfPrevSrch = parseString.indexOf("<" +
                                                  toUpperCase(valueOf) +
                                                  ">");
            return copyString.substring(indexOfPrevSrch +
                    valueOf.length() +
                    2,
                    parseString.indexOf("</" +
                                        toUpperCase(valueOf) + ">"));
        } catch (StringIndexOutOfBoundsException
                 stringindexoutofboundsexception) {
            return "";
        }
    }

    public String getFirstValueOf(String valueOf, int start) {
        try {
            indexOfPrevSrch = parseString.indexOf("<" +
                                                  toUpperCase(valueOf) +
                                                  ">", start);
            return copyString.substring(indexOfPrevSrch +
                    valueOf.length() +
                    2,
                    parseString.indexOf("</" +
                                        toUpperCase(valueOf) + ">", start));
        } catch (StringIndexOutOfBoundsException
                 stringindexoutofboundsexception) {
            return "";
        }
    }

    public String getNextValueOf(String valueOf) {
        try {
            indexOfPrevSrch = parseString.indexOf("<" +
                                                  toUpperCase(valueOf) +
                                                  ">",
                                                  indexOfPrevSrch +
                                                  valueOf.length() +
                                                  2);
            return copyString.substring(indexOfPrevSrch +
                    valueOf.length() +
                    2,
                    parseString.indexOf("</" +
                                        toUpperCase(valueOf) + ">",
                                        indexOfPrevSrch));
        } catch (StringIndexOutOfBoundsException
                 stringindexoutofboundsexception) {
            return "";
        }
    }

    public int getNoOfFields(String tag) {
        int noOfFields = 0;
        int beginPos = 0;
        try {
            for (tag = toUpperCase(tag) + ">";
                       parseString.indexOf("<" + tag, beginPos) != -1;
                       beginPos += tag.length() + 2) {
                noOfFields++;
                beginPos = parseString.indexOf("</" + tag, beginPos);
                if (beginPos == -1) {
                    break;
                }
            }

        } catch (StringIndexOutOfBoundsException
                 stringindexoutofboundsexception) {noOfFields=0;}
        return noOfFields;
    }

    public int getNoOfFields(String tag, int startPos, int endPos) {
        int noOfFields = 0;
        int beginPos = startPos;
        try {
            for (tag = toUpperCase(tag) + ">";
                       parseString.indexOf("<" + tag, beginPos) != -1 &&
                       (beginPos < endPos || endPos == 0); ) {
                beginPos = parseString.indexOf("</" + tag, beginPos) +
                           tag.length() + 2;
                if (beginPos != -1 && (beginPos <= endPos || endPos == 0)) {
                    noOfFields++;
                }
            }

        } catch (StringIndexOutOfBoundsException
                 stringindexoutofboundsexception) {noOfFields=0;}
        return noOfFields;
    }

    public String convertToSQLString(String strName) {
        try {
            for (int count = strName.indexOf('['); count != -1;
                             count = strName.indexOf('[', count + 2)) {
                strName = strName.substring(0, count) + "[[]" +
                          strName.substring(count + 1, strName.length());

            }
        } catch (Exception exception) {
        	strName="";
        }
        try {
            for (int count = strName.indexOf('_'); count != -1;
                             count = strName.indexOf('_', count + 2)) {
                strName = strName.substring(0, count) + "[_]" +
                          strName.substring(count + 1, strName.length());

            }
        } catch (Exception exception1) {
        	strName="";
        }
        try {
            for (int count = strName.indexOf('%'); count != -1;
                             count = strName.indexOf('%', count + 2)) {
                strName = strName.substring(0, count) + "[%]" +
                          strName.substring(count + 1, strName.length());

            }
        } catch (Exception exception2) {
        	strName="";
        }
        strName = strName.replace('?', '_');
        return strName;
    }

    public String getValueOf(String valueOf, String type, int from, int end) {
        try {
            if (type.equalsIgnoreCase("Binary")) {
                int startPos = copyString.indexOf("<" + valueOf + ">", from);
                if (startPos == -1) {
                    return "";
                }
                int endPos = copyString.indexOf("</" + valueOf + ">", from);
                if (endPos > end) {
                    return "";
                } else {
                    startPos += ("<" + valueOf + ">").length();
                    return copyString.substring(startPos, endPos);
                }
            } else {
                return "";
            }
        } catch (StringIndexOutOfBoundsException
                 stringindexoutofboundsexception) {
            return "";
        }
    }

    public String toUpperCase(String valueOf) 
             {
        String returnStr = "";
        try {
            int count = valueOf.length();
            char[] strChar = new char[count];
            valueOf.getChars(0, count, strChar, 0);
            while (count-- > 0) {
                strChar[count] = Character.toUpperCase(strChar[count]);
            }
            returnStr = new String(strChar);
        } catch (ArrayIndexOutOfBoundsException arrayindexoutofboundsexception) {
        	returnStr="";
        }
        return returnStr;
    }

    public String changeValue(String parseString, String tagName,
                              String newValue) {
        try {
            String parseStringTmp = parseString.toUpperCase();
            String strTag = ("<" + tagName + ">").toUpperCase();
            int startIndex = parseStringTmp.indexOf(strTag) + strTag.length();
            int endIndex = parseStringTmp.indexOf(("</" + tagName +
                    ">").
                                                  toUpperCase());
            String retStr = parseString.substring(0, startIndex);
            retStr = retStr + newValue + parseString.substring(endIndex);
            return retStr;
        } catch (Exception exception) {
            return "";
        }
    }

    public void changeValue(String tagName, String newValue) {
        try {
            String strTag = ("<" + tagName + ">").toUpperCase();
            int startIndex = parseString.indexOf(strTag);
            if (startIndex > -1) {
                startIndex += strTag.length();
                int endIndex = parseString.indexOf(("</" + tagName + ">").
                        toUpperCase());
                String retStr = copyString.substring(0, startIndex);
                copyString = retStr + newValue + copyString.substring(endIndex);
            } else {
                int endIndex = startIndex = parseString.lastIndexOf("</");
                String retStr = copyString.substring(0, startIndex);
                copyString = retStr + "<" + tagName + ">" + newValue + "</" +
                             tagName +
                             ">" + copyString.substring(endIndex);
            }
            parseString = toUpperCase(copyString);
        } catch (Exception exception) {
        	parseString="";
        }
    }

    public String toString() {
        return copyString;
    }
}
