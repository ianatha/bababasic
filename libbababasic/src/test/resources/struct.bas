' Test struct

PRINT "STRUCT1"

STRUCT struct1 { A% , B% }
struct1 s1 {}
struct1 s2 {}

PRINT s1.A%, s2.A%

s1.A% = 2
s2.A% = 10
PRINT s1.A%, s2.A%

s1.A% = s2.A%
PRINT s1.A%, s2.A%

s1.A% = 11
s2.A% = 12
s2 = s1
PRINT s1.A%, s2.A%

PRINT "STRUCT2"

STRUCT struct2 { C% , struct1 child }
struct2 s3 {}
struct2 s4 {}

s3.child.A% = 100
s3.C% = 50
PRINT s3.child.A%, s3.C%

PRINT "STRUCT3"

STRUCT struct3 { A% , DIM B%(2,5) }
struct3 s31 {}
s31.B%(1, 4) = 10
PRINT s31.B%(1, 4)

PRINT "STRUCT4"

STRUCT struct4 { A%, B@, C!, D#, E$, DIM ARR%(2,3), LIST<$> l1, SET<%> s1, DICT<%, #> d1 }
struct4 s41 {}
s41.A% = 1
s41.B@ = 2
s41.C! = 3
s41.D# = 4
s41.E$ = "str"
s41.ARR%(1, 1) = 5
s41.l1.append("abc")
s41.s1.add(23)
s41.d1.put(10, 2.5)
PRINT s41.A%, s41.B@, s41.C!, s41.D#, s41.E$, s41.ARR%(1, 1), s41.l1.get(0), s41.s1.contains(23), s41.d1.getOrDefault(10, 0)
