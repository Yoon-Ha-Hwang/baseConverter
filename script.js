let display1 = document.getElementById("display1");
let display2 = document.getElementById("display2");

const baseSymbolMap = {
  "0": 10,
  "1": 1,
  "2": 2,
  "3": 3,
  "4": 4,
  "5": 5,
  "6": 6,
  "7": 7,
  "8": 8,
  "9": 9,
  "A": 11,
  "B": 12,
  "C": 13,
  "D": 14,
  "E": 15,
  "F": 16,
};

let currentValue = "";
let step = 1;
let orgNum = "";
let orgBase = 0;
let newNum = "";
let newBase = 0;
let valueInBaseTen = 0;

function updateText() {
  display1.textContent = currentValue;
}

function setInstruction(message) {
  display2.innerHTML = message;
}

function addNumber(value) {
  currentValue += value.toString();
  updateText();
}

function addLetter(value) {
  currentValue += value;
  updateText();
}

function backspace() {
  currentValue = currentValue.substring(0, currentValue.length - 1);
  updateText();
}

function resetEntry() {
  currentValue = "";
  updateText();
}

const numberMap = {
  "0": 0,
  "1": 1,
  "2": 2,
  "3": 3,
  "4": 4,
  "5": 5,
  "6": 6,
  "7": 7,
  "8": 8,
  "9": 9,
  "A": 10,
  "B": 11,
  "C": 12,
  "D": 13,
  "E": 14,
  "F": 15,
};

function toDecimal(base, value) { /* Non Base 10 => Base 10 */
    let answer = 0;
    /* The highest place value is index 0 of the string. I'm reversing the string so the highest place value appears at the end */
    let reversedValue = "";
    while(value.length != 0) {
        reversedValue += value.substring(value.length - 1, value.length); 
        value = value.substring(0, value.length - 1);
    }

    for (let i = 0; i < reversedValue.length; i++) {
        let digit = numberMap[reversedValue.substring(i, i + 1)]; 
        answer += digit * Math.pow(base, i);
    }
    return answer;
}

function fromDecimal(base, value) { /* Base 10 => Non Base 10 */
    let numDigits = 0;
    let answer = "";
    while(Math.pow(base, numDigits) < value) {
        numDigits++;
    }
    numDigits--; /* I added this one because when it exists the loop base^numDigits > value and that causes a leading zero */
    for(let i = numDigits; i >= 0; i--) {
        const digitMap = {
            0: "0",
            1: "1",
            2: "2",
            3: "3",
            4: "4",
            5: "5",
            6: "6",
            7: "7",
            8: "8",
            9: "9",
            10: "A",
            11: "B",
            12: "C",
            13: "D",
            14: "E",
            15: "F"
        }
        let placeValue = Math.pow(base, i);
        let digit = Math.floor(value / placeValue);
        answer += digitMap[digit];
        value -= digit * placeValue;
    }
    return answer;
}

/*
    Step 1 = User is entering the base value of the original number
    Step 2 = User is entering the original number itself
    Step 3 = User is entering the new base value
*/ 

function nextStep() {
  if (step == 1) {
    base = currentValue;
    if (!base || base.length != 1) {
      setInstruction("Please enter a single digit representing the base.");
      resetEntry();
      return;
    }

    orgBase = baseSymbolMap[base];
    step = 2;
    setInstruction("Now enter the value in base " + orgBase + " that you want to convert.");
    resetEntry();
    return;
  }

  if (step == 2) {
    if (!currentValue) {
      setInstruction("Please enter a value to convert.");
      return;
    }

    let invalidDigit = "X";
    for(let i = 0; i < currentValue.length; i++) {
        if(baseSymbolMap[currentValue.substring(i, i + 1)] > orgBase) {
            invalidDigit = currentValue.substring(i, i + 1);
        }
    }

    if (invalidDigit != "X") { /* Changed means something was entered incorrectly */
      setInstruction("The value " + invalidDigit + " isn't valid in base " + orgBase + ". In base " + orgBase + " you can only enter values that are strictly less than " + orgBase + "; please enter again.");
      resetEntry();
      return;
    }

    orgNum = currentValue;
    valueInBaseTen = toDecimal(orgBase, orgNum);
    step = 3;
    setInstruction("To which base would you like to convert this number to? <br><small>Enter one value only. For base 10, enter 0; base 11, A; base 12, B; base 13, C; base 14, D; base 15, E; and base 16, F.</small>");
    resetEntry();
    return;
  }

  if (step == 3) {
    if (currentValue == null || currentValue.length != 1) {
      setInstruction("Please enter a single digit representing the base.");
      resetEntry();
      return;
    }

    newBase = baseSymbolMap[currentValue];
    newNum = fromDecimal(newBase, valueInBaseTen);
    step = 4;
    setInstruction(orgNum + " in base " + orgBase + " is " + newNum + " in base " + newBase + ".<br>Click on Confirm to perform another calculation.");
    resetEntry();
    return;
  }

  if (step == 4) {
    step = 1;
    setInstruction("Enter the base of the original number. <br><small>Enter one value only. For base 10, enter 0; base 11, A; base 12, B; base 13, C; base 14, D; base 15, E; and base 16, F.</small>");
    resetEntry();
    updateText();
    return;
  }
}

setInstruction("Enter the base of the original number.<br><small>Enter one value only. For base 10, enter 0; base 11, A; base 12, B; base 13, C; base 14, D; base 15, E; and base 16, F.</small>");
updateText();
