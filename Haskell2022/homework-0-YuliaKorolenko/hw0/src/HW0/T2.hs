module HW0.T2
  ( Not
  , doubleNeg
  , reduceTripleNeg
  ) where

import Data.Void (Void)

type Not a = a -> Void


-- (a -> (a -> Void) -> Void)
doubleNeg :: a -> Not (Not a)
doubleNeg a f = f a

-- (((a -> Void) -> Void) -> Void) -> (a -> Void)
-- (((a -> Void) -> Void) -> Void) -> a -> Void
-- d                               -> a -> Void
-- (doubleNeg a) -> ((a -> Void) -> Void)
-- d (doubleNeg a) -> Void
reduceTripleNeg :: Not (Not (Not a)) -> Not a
reduceTripleNeg d a = d (doubleNeg a)
