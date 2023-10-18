module HW1.T1 
  ( Day (..)
  , afterDays
  , daysToParty
  , isWeekend
  , nextDay
  ) where

import GHC.Natural (Natural)

data Day = Monday | Tuesday | Wednesday | Thursday | Friday | Saturday | Sunday deriving (Show)


-- | Returns the day that follows the day of the week given as input.
nextDay :: Day -> Day
nextDay Monday = Tuesday
nextDay Tuesday = Wednesday
nextDay Wednesday = Thursday
nextDay Thursday = Friday
nextDay Friday = Saturday
nextDay Saturday = Sunday
nextDay Sunday = Monday


-- | Checks if the day is on the weekend.
isWeekend :: Day -> Bool
isWeekend Saturday = True
isWeekend Sunday = True
isWeekend _ = False

-- | Returns the day of the week after a given number of days has passed.
afterDays :: Natural -> Day -> Day
afterDays 0 currentDay = currentDay
afterDays a currentDay = afterDays (a-1) (nextDay currentDay)


-- | Computes the number of days until Friday.
daysToParty :: Day -> Natural
daysToParty currentDay = toParty currentDay 0

toParty :: Day -> Natural -> Natural
toParty Friday currentCount = currentCount
toParty currentDay currentCount = toParty (nextDay currentDay) (currentCount + 1)
