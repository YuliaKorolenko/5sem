module HW2.T1
( Option(..)
, mapOption
, Pair(..)
, mapPair
, Quad(..)
, mapQuad
, Annotated(..)
, mapAnnotated 
, Except(..)
, mapExcept
, Prioritised(..)
, mapPrioritised
, Stream(..)
, mapStream
, List(..)
, mapList
, Fun(..)
, mapFun
, Tree(..)
, mapTree
) where

data Option a = None | Some a


mapOption :: (a -> b) -> (Option a -> Option b)
mapOption _ None = None
mapOption f (Some a) = Some (f a  )

data Pair a = P a a

mapPair        :: (a -> b) -> (Pair a -> Pair b)
mapPair f (P a_1 a_2) = P (f a_1) (f a_2)


data Quad a = Q a a a a

mapQuad :: (a -> b) -> (Quad a -> Quad b)
mapQuad f (Q a_0 a_1 a_2 a_3) = Q (f a_0) (f a_1) (f a_2) (f a_3)

data Annotated e a = a :# e
infix 0 :#

mapAnnotated :: (a -> b) -> (Annotated e a -> Annotated e b)
mapAnnotated f (a :# e) = (f a) :# e

data Except e a = Error e | Success a

mapExcept :: (a -> b) -> (Except e a -> Except e b)
mapExcept _ (Error e) = Error e
mapExcept f (Success a) = Success (f a)

data Prioritised a = Low a | Medium a | High a

mapPrioritised :: (a -> b) -> (Prioritised a -> Prioritised b)
mapPrioritised f p =
    case p of
        Low a -> Low (f a)
        Medium a -> Medium (f a)
        High a -> High (f a)

data Stream a = a :> Stream a
infixr 5 :>

mapStream :: (a -> b) -> (Stream a -> Stream b)
mapStream f (a :> b) = (f a) :> (mapStream f b)

data List a = Nil | a :. List a
infixr 5 :.

mapList :: (a -> b) -> (List a -> List b)
mapList _ Nil = Nil
mapList f (a :. l) = f a :. mapList f l

data Fun i a = F (i -> a)

-- (.) (a -> b) -> (i -> a) -> (i -> b)
mapFun :: (a -> b) -> (Fun i a -> Fun i b)
mapFun f (F fun) = F (f . fun)


data Tree a = Leaf | Branch (Tree a) a (Tree a)

mapTree :: (a -> b) -> (Tree a -> Tree b)
mapTree _ Leaf = Leaf
mapTree f (Branch leftTree a rightTree) = Branch (mapTree f leftTree) (f a) (mapTree f rightTree)


