{-# LANGUAGE TypeOperators #-}

module HW0.T1
 ( type (<->) (..) 
 , flipIso
 , runIso
 , distrib
 , assocPair
 , assocEither
 ) where

data a <-> b = Iso (a -> b) (b -> a)

flipIso :: (a <-> b) -> (b <-> a)
flipIso (Iso f g) = Iso g f

runIso :: (a <-> b) -> (a -> b)
runIso (Iso f _) = f

-- a or (b and c) -> (a or b) and (a or c)
-- a == true ->  true and true
-- if 2 -> (b == True and c == true)
distrib :: Either a (b, c) -> (Either a b, Either a c)
distrib (Left a) = (Left a, Left a)
distrib (Right (b, c)) = (Right b, Right c)

-- ассоциативность
assocPair :: (a, (b, c)) <-> ((a, b), c)
assocPair = Iso
                (\(a, (b, c)) -> ((a, b), c)) 
                (\((a, b), c) -> (a, (b, c)))

-- first a or (b or c) -> (a or b) or c
-- a == true -> True a or True
-- b = true -> True b? or True c
-- c = true -> 
-- second (a or b) or c -> a or (b or c)
assocEither :: Either a (Either b c) <-> Either (Either a b) c
assocEither = (Iso first second)
                    where 
                        first (Left a) = (Left (Left a))
                        first (Right (Left b)) = (Left (Right b))
                        first (Right (Right c)) = Right c
                        second (Left (Left a)) = Left a
                        second (Left (Right b)) = (Right (Left b))
                        second (Right c) = (Right (Right c))