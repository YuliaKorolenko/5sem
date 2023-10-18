module HW1.T7
  ( ListPlus(..)
  , DotString(..)
  , Fun(..)
  , Inclusive(..)
  ) where

data ListPlus a = a :+ ListPlus a | Last a deriving (Show)
infixr 5 :+

instance Semigroup (ListPlus a) where
  (Last a) <> b = a :+ b
  (a :+ b) <> c = a :+ (b <> c)


data Inclusive a b = This a | That b | Both a b deriving (Show)

instance (Semigroup a, Semigroup b) => Semigroup (Inclusive a b) where
  (<>) (This a) (This b)     = This (a <> b)
  (<>) (This a) (That b)     = Both a b
  (<>) (That a) (This b)     = Both b a
  (<>) (That a) (That b)     = That (a <> b)
  (<>) (Both a b) (This c)   = Both (a <> c) b
  (<>) (Both a b) (Both c d) = Both (a <> c) (b <> d)
  (<>) (Both a b) (That c)   = Both a (b <> c)
  (<>) (This a) (Both b c)   = Both (a <> b) c
  (<>) (That a) (Both b c)   = Both b (a <> c)
  -- in first this in the second that
 

newtype DotString = DS String deriving (Show)

instance Semigroup DotString where
    (DS "") <> c = c
    c <> (DS "") = c
    (DS a) <> (DS b) = DS (a ++ "." ++ b)

instance Monoid DotString where
  mempty = DS ""


newtype Fun a = F (a -> a) 

instance Semigroup (Fun a) where
  (F x) <> (F y) = F (x . y)

