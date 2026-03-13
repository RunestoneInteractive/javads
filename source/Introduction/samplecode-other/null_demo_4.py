import random
text = "hello"
if random.random() < 0.001:
    text = None
if text is not None:
    print(text.upper())
else:
    print("Text is None.")
