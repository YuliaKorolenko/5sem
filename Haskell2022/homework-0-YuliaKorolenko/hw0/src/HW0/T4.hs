module HW0.T4
  ( repeat'
  , map'
  , fib
  , fac
  ) where

import           Data.Function (fix)
import GHC.Natural (Natural)

repeat' :: a -> [a]             -- behaves like Data.List.repeat
repeat' x = fix (x:) 

map' :: (a -> b) -> [a] -> [b]  -- behaves like Data.List.map
map' f = fix (\recurse list ->
    case list of
        [] -> []
        (x:xs) -> f x : recurse xs)



fib :: Natural -> Natural       -- computes the n-th Fibonacci number
fib = fix (\fibonacci n ->
    case n of
        0 -> 0
        1 -> 1
        _ -> fibonacci (n - 1) + (fibonacci (n - 2)))




fac :: Natural -> Natural       -- computes the factorial
fac = fix (\factorial n ->
    case n of 
        0 -> 1
        1 -> 1
        _ -> factorial (n - 1) * n)