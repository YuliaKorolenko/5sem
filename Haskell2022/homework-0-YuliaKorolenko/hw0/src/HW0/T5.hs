module HW0.T5
 ( Nat
 , nz
 , ns
 , nplus
 , nmult
 , nFromNatural
 , nToNum 
 ) where


import GHC.Natural (Natural)

type Nat a = (a -> a) -> a -> a



nz :: Nat a  -- 0
nz _ x = x

-- (a -> a) - (a -> a)
-- ((a -> a) ->(a -> a)) -> (a -> a) -> a -> a
-- p                        f           a
-- p f = (a -> a) \\prev result
-- 
ns :: Nat a -> Nat a -- (a -> a) // operation -> (a -> a) // "count" of my operations (previous a -> current a)
ns p f = f . (p f)

nplus, nmult :: Nat a -> Nat a -> Nat a


-- ((a -> a) -> a -> a) -> ((a -> a) -> a -> a) -> (a -> a) -> a -> a
-- x                    -> y                    -> f        -> res
-- x f == current x   y f = cuurent y . - compose
nplus x y f = (x f) . (y f)
nmult n m f = n (m f)

nFromNatural :: Natural -> Nat a

nFromNatural 0 = nz
nFromNatural nat = ns (nFromNatural (nat - 1))


-- (a -> a) -> (a -> a)
-- nToNum :: Num a => Nat a -> a
nToNum :: Num a => Nat a -> a
nToNum f = f (+1) 0 




