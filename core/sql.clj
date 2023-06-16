(select ([f1, f2, f3... | *])
        (form (t1 | (join t1 t2 (on t1f t2f)) | (select ...)))
        (where (c1 | (and c1 c2 c3) | (or c1 c2 c3) | (and c1 (or c2 c3))))
        (group-by ([f1, f2] (having (c1))))
        (order-by (do (desc f1) (asc f2))))

c => (c)
