  select a.id, isnull(b.student,a.student) as student
  from
    seat a left join
    seat b
    on
(a.id%2=1 and a.id=b.id-1)
  where a.id%2=1
union
  select a.id, b.student as student
  from
    seat a left join
    seat b
    on
a.id%2=0 and a.id=b.id+1
  where a.id%2=0
