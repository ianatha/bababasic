PRINT "SET of STRING"

SET<$> set1

set1.add("a")
set1.add("a")
PRINT LEN(set1)

PRINT set1.contains("a")

auto s1val = set1.values()
FOR I% = 0 TO LEN(s1val) - 1
  PRINT s1val(I%),
NEXT : PRINT ""

set1.remove("a")
PRINT LEN(set1)

set1.clear()
PRINT LEN(set1)

PRINT "SET of INT32"

SET<%> set2

set2.add(10)
set2.add(20)
PRINT LEN(set2)

PRINT set2.contains(10)

set2.remove(10)
PRINT LEN(set2)

set2.clear()
PRINT LEN(set2)

PRINT "SET of INT64"

SET<@> set3

set3.add(100)
set3.add(200)
PRINT LEN(set3)

PRINT set3.contains(100)

set3.remove(100)
PRINT LEN(set3)

set3.clear()
PRINT LEN(set3)

PRINT "SET of FLOAT32"

SET<!> set4

set4.add(10.1)
set4.add(20.1)
PRINT LEN(set4)

PRINT set4.contains(10.1)

set4.remove(10.1)
PRINT LEN(set4)

set4.clear()
PRINT LEN(set4)

PRINT "SET of FLOAT64"

SET<#> set5

set5.add(100.1)
set5.add(200.1)
PRINT LEN(set5)

PRINT set5.contains(100.1)

set5.remove(100.1)
PRINT LEN(set5)

set5.clear()
PRINT LEN(set5)
