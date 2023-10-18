module HW0.T3
  ( s
  , k
  , i
  , compose 
  , contract
  , permute
  ) where

s :: (a -> b -> c) -> (a -> b) -> (a -> c)
s f g x = f x (g x)

k :: a -> b -> a
k x _ = x

-- 1. (a -> b -> a) -> (a -> b) -> (a -> a)      s
-- 2. a -> b -> a                                k
-- 3. (a -> b) -> (a -> a)                       MP 1 2  = s k
-- 3. 1  (a -> (b1 -> a)) -> (a -> a)            это 3е утверждение, где b = b1 -> a           
-- 4. a -> a                                     MP 3.1 2 = s k k
i :: a -> a
i = s k k

-- (b -> )
-- 1.   (a -> b -> a) -> (a -> b) -> (a -> a)                  s
-- 2.   a -> b -> a                                            k
-- 3.   s -> b1 -> s                                           k, where a == s
-- 3.1  b1 -> (a -> b -> c) -> ((a -> b) -> (a -> c))          MP 3 1 = ks
-- 4.   a = b1,  b = (a -> b -> c), c = ((a -> b) -> (a -> c)) s with that a b c
-- 4.1  (b1 -> (a -> b -> c)) -> (b1 -> (a -> b) -> (a -> c))  MP 4 3.1 = s ks
-- 5. b1 = (a -> b -> c) -> b
compose :: (b -> c) -> (a -> b) -> (a -> c)
compose = s (k s) k

-- undefined contract :: (a -> a -> b) -> (a -> b)
contract :: (a -> a -> b) -> (a -> b) 
contract = s s s k

-- undefined permute :: (a -> b -> c) -> (b -> a -> c)
permute :: (a -> b -> c) -> (b -> a -> c)
permute = undefined
