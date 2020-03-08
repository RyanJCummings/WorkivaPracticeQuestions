# Problem 1 from Workiva practice interview questions
# Takes in an ordered list of strings
# Returns an "interlaced" string containing all the letters

# Kind of a naive solution. Could optimize by encapsulating
# if checks with another function that parameterizes strings, checks 
# length, slices the string, and updates interlacedString 
def zip(inString_1, inString_2, inString_3):
    print("Input String: " + inString_1 + ", " + inString_2 + ", " + inString_3)
    interlacedString = ""

    # Will need single elements at a time.  
    # String slicing should be useful here
    while(len(inString_1) != 0 or len(inString_2) != 0 or len(inString_3) != 0):
        if len(inString_1) != 0:
            interlacedString += inString_1[0]
            inString_1 = inString_1[1:]
        if len(inString_2) != 0:
            interlacedString += inString_2[0]
            inString_2 = inString_2[1:]
        if len(inString_3) != 0:
            interlacedString += inString_3[0]
            inString_3 = inString_3[1:]

    return "Output String: " + interlacedString

def main():
    print(zip("AAA","BBBBX","CCCsss4"))

main()
