Select p1.Email
FROM Person p1
group by Email
having count(*) > 1;
