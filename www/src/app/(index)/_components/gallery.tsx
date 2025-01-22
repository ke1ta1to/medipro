import Image from "next/image";

const screenshots = [
  {
    href: "/screenshot-2.png",
    width: 2110,
    height: 1334,
  },
  {
    href: "/screenshot-3.png",
    width: 2110,
    height: 1334,
  },
  {
    href: "/screenshot-1.png",
    width: 2110,
    height: 1334,
  },
];

export function Gallery() {
  return (
    <div className="not-prose flex flex-col justify-center gap-4">
      {screenshots.map((screenshot, index) => (
        <Image
          key={index}
          alt={`Screenshot ${index + 1}`}
          src={screenshot.href}
          width={screenshot.width}
          height={screenshot.height}
        />
      ))}
    </div>
  );
}
