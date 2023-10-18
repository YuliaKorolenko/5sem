module HW1.T4
    ( treeToList
    , tfoldr
    ) where


import HW1.T3(Tree(..))

tfoldr :: (a -> b -> b) -> b -> Tree a -> b
tfoldr _ b Leaf = b 
tfoldr func b (Branch _ l vert r) = tfoldr func (func vert (tfoldr func b r)) l


treeToList :: Tree a -> [a]    -- output list is sorted
treeToList = tfoldr (:) []