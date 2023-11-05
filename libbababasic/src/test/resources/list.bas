PRINT "LIST of STRING"

LIST<$> list1
PRINT len(list1)

list1.append("a")
list1.append("b")
PRINT list1.get(0)
PRINT list1.get(1)
PRINT len(list1)

auto l1val = list1.values()
FOR I% = 0 TO LEN(l1val) - 1
  PRINT l1val(I%),
NEXT : PRINT ""

list1.insert(0, "c")
PRINT list1.get(0)
PRINT len(list1)

list1.clear()
PRINT len(list1)

PRINT "LIST of INT32"

LIST<%> list2
PRINT len(list2)

list2.append(1)
list2.append(2)
PRINT list2.get(0)
PRINT list2.get(1)
PRINT len(list2)

auto l2val = list2.values()
FOR I% = 0 TO LEN(l2val) - 1
  PRINT l2val(I%),
NEXT : PRINT ""

list2.insert(0, 3)
PRINT list2.get(0)
PRINT len(list2)

list2.clear()
PRINT len(list2)

PRINT "LIST of INT64"

LIST<@> list3
PRINT len(list3)

list3.append(10)
list3.append(20)
PRINT list3.get(0)
PRINT list3.get(1)
PRINT len(list3)

auto l3val = list3.values()
FOR I% = 0 TO LEN(l3val) - 1
  PRINT l3val(I%),
NEXT : PRINT ""

list3.insert(0, 30)
PRINT list3.get(0)
PRINT len(list3)

list3.clear()
PRINT len(list3)

PRINT "LIST of FLOAT32"

LIST<!> list4
PRINT len(list4)

list4.append(1.1)
list4.append(2.1)
PRINT list4.get(0)
PRINT list4.get(1)
PRINT len(list4)

auto l4val = list4.values()
FOR I% = 0 TO LEN(l4val) - 1
  PRINT l4val(I%),
NEXT : PRINT ""

list4.insert(0, 3.1)
PRINT list4.get(0)
PRINT len(list4)

list4.clear()
PRINT len(list4)

PRINT "LIST of FLOAT64"

LIST<#> list5
PRINT len(list5)

list5.append(10.1)
list5.append(20.1)
PRINT list5.get(0)
PRINT list5.get(1)
PRINT len(list5)

auto l5val = list5.values()
FOR I% = 0 TO LEN(l5val) - 1
  PRINT l5val(I%),
NEXT : PRINT ""

list5.insert(0, 30.1)
PRINT list5.get(0)
PRINT len(list5)

list5.clear()
PRINT len(list5)

LIST<DIM %> list6
DIM D0%(5)
DIM D1%(5)
D0%(0) = 10
D1%(0) = 20
list6.append(D0%)
list6.append(D1%)
AUTO x0 = list6.get(0)
AUTO x1 = list6.get(1)
PRINT x0(0), x1(0)

STRUCT Struct1 { X$ }
Struct1 s1 {}
s1.X$ = "A10"
LIST<Struct1> list7
list7.append(s1)
AUTO x70 = list7.get(0)
PRINT x70.X$
