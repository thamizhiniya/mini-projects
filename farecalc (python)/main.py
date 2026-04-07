Rates={'economy': 10, 'premium' : 18, 'suv' : 25}

def calculate_fare(km,type,hour):
    try:
        rate = Rates[type]
    except KeyError:
        return None

    fare = rate * km
    
    if hour >= 17 and hour <= 20:
        fare *= 1.5

    return fare

type=input("Enter the type of car (economy, premium, suv): ")
if type not in Rates:
    print("Service Not Available")
else:
    km=float(input("Enter the distance in km: "))
    hour=int(input("Enter the hour of the day (0-23): "))
    fare = calculate_fare(km, type, hour) 
    print("\n -----Price Receipt-----")
    print(f"Distance    : {km} km")
    print(f"Car Type    : {type}")
    print(f"Hour        : {hour}")
    print(f"Fare        : Rs {fare:.2f}")
