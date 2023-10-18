module HW1.T3
( Tree(..)
, tsize
, tdepth
, tmember
, mkBranch
, tinsert
, tFromList
) where

import Data.Foldable ()

data Tree a = Leaf | Branch Meta (Tree a) a (Tree a) deriving (Show)

type Meta = Int    

-- | Size of the tree, O(1).
tsize :: Tree a -> Int
tsize Leaf = 0
tsize (Branch meta _ _ _) = meta

-- | Depth of the tree.
tdepth :: Tree a -> Int
tdepth Leaf = 0
tdepth (Branch _ l _ r) = max (tdepth l) (tdepth r) + 1

-- | Check if the element is in the tree, O(log n)
tmember :: Ord a => a -> Tree a -> Bool
tmember _ Leaf = False
tmember a (Branch _ l b r) =  
    case (compare a b) of
    EQ -> True
    LT  -> tmember a l
    GT -> tmember a r


mkBranch :: Tree a -> a -> Tree a -> Tree a
mkBranch Leaf a Leaf = Branch 1 Leaf a Leaf
mkBranch Leaf a r@(Branch metar _ _ _) = Branch (metar + 1) Leaf a r
mkBranch l@(Branch metal _ _ _) a Leaf = Branch (metal + 1) l a Leaf
mkBranch l@(Branch metal _ _ _) a r@(Branch metar _ _ _) = Branch (metal + metar + 1) l a r

-- | Insert an element into the tree, O(log n)
tinsert :: Ord a => a -> Tree a -> Tree a
tinsert a Leaf = mkBranch Leaf a Leaf
tinsert a tree@(Branch _ l b r) = 
    case (compare a b) of
        EQ -> tree
        LT -> tinsert a l
        GT -> tinsert a r

-- | Build a tree from a list, O(n log n)
tFromList :: Ord a => [a] -> Tree a
tFromList [] = Leaf
tFromList (h : t) = tinsert h (tFromList t)
