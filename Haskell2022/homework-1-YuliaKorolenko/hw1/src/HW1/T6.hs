module HW1.T6
    ( mcat
    , epart
    ) where

import           Data.Foldable (fold)

mcat :: Monoid a => [Maybe a] -> a
mcat = fold . fold

-- fold :: (Foldable t, Monoid m) => t m -> m

-- foldMap :: Monoid m => (a -> m) -> t a -> m
-- mconcat :: [a] -> a
epart :: (Monoid a, Monoid b) => [Either a b] -> (a, b)
epart x =  (
    (foldMap leftFunc x),
    (foldMap rightFunc x)
    ) where
        leftFunc (Left a) = a
        leftFunc (Right _) = mempty
        rightFunc (Left _) = mempty
        rightFunc (Right b) = b

