module HW1.T2
    ( N (..)
    , nplus
    , nmult
    , nsub
    , ncmp
    , nFromNatural
    , nToNum
    , nEven
    , nOdd
    , ndiv
    , nmod
    ) where

import           Numeric.Natural
import           Data.Maybe()

data N = Z | S N deriving (Show)

nplus :: N -> N -> N        -- addition
nplus Z a = a
nplus a Z = a
nplus (S firstEl) secondEl = S ( nplus firstEl secondEl)

-- постепенно делаю первый элемент Z, тогда вернется Sssss (Z a) = s(a)

nmult :: N -> N -> N        -- multiplication
nmult Z _ = Z
nmult _ Z = Z
nmult firstEl (S secondEl) = nplus (nmult firstEl secondEl) firstEl 
-- (a' b) = a + (a b) 



nsub :: N -> N -> Maybe N   -- subtraction     (Nothing if result is negative)
nsub Z (S _) = Nothing
nsub a Z = Just a
nsub (S a) (S b) = nsub a b


ncmp :: N -> N -> Ordering  -- comparison      (Do not derive Ord)
ncmp a b = 
    case nsub a b of
    Just Z -> EQ
    Nothing  -> LT
    Just _ -> GT
-- LT <
-- GT >
-- EQ =

nFromNatural :: Natural -> N
nFromNatural a = nFrom a Z

nFrom :: Natural -> N -> N
nFrom 0 b = b
nFrom a b = nFrom (a-1) (S b)


nToNum :: Num a => N -> a
nToNum b = nTo b 0

nTo :: Num a =>  N -> Natural -> a
nTo Z a = fromIntegral a
nTo (S a) b = nTo a (b + 1)

nmod :: N -> N -> N         -- modulo operation
nmod a b = 
    case nsub a b of
        Nothing  -> a
        Just c -> nmod c b
    

nEven, nOdd :: N -> Bool    -- parity checking
nEven a = (==) EQ $ ncmp (nmod a (S (S Z))) Z
nOdd a = not (nEven a)

ndiv :: N -> N -> N
ndiv a Z = ndiv a Z
ndiv a b = ndivCounter a b Z

ndivCounter :: N -> N -> N -> N
ndivCounter a b c =
    case nsub a b of
        Nothing -> c 
        Just d -> ndivCounter d b $ S c

