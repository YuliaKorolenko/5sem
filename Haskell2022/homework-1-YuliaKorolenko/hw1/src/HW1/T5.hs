module HW1.T5 
    ( splitOn
    , joinWith
    ) where

import Data.Foldable ()
import                Data.List.NonEmpty
import                       Data.List()

splitOn :: Eq a => a -> [a] -> NonEmpty [a]
splitOn sep = foldr splitHelp ([] :| []) where 
 splitHelp h1 (h2 :| t2) = 
    if h1 == sep
    then  [] :| (h2 : t2)
    else  (h1 : h2) :| t2

-- : a [a] -> [a]
-- :| [a] [[a]] -> [[a]]
-- splitHelp h1 = a h2 = [a] t2 = [[a]]

joinWith :: a -> NonEmpty [a] -> [a]
joinWith sep = foldr1 (\h t ->  h ++ (sep : t))